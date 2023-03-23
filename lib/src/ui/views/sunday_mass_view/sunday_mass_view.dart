import 'package:canton_ui/canton_ui.dart';
import 'package:flutter/services.dart';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:youtube_player_iframe/youtube_player_iframe.dart';

import 'package:bibliafree/src/models/youtube_channel.dart';
import 'package:bibliafree/src/providers/local_user_repository_provider.dart';
import 'package:bibliafree/src/providers/sunday_mass_service_provider.dart';
import 'package:bibliafree/src/providers/youtube_fetch_channel_future_provider.dart';
import 'package:bibliafree/src/providers/youtube_fetch_latest_church_video_future_provider.dart';
import 'package:bibliafree/src/ui/views/sunday_mass_view/components/church_youtube_channel_card.dart';
import 'package:bibliafree/src/ui/views/sunday_mass_view/components/sunday_mass_view_header.dart';

class SundayMassView extends ConsumerStatefulWidget {
  const SundayMassView({Key key}) : super(key: key);

  @override
  ConsumerState<SundayMassView> createState() => _SundayMassViewState();
}

class _SundayMassViewState extends ConsumerState<SundayMassView> {
  @override
  Widget build(BuildContext context) {
    return CantonScaffold(
      body: _content(context, ref),
    );
  }

  Widget _content(BuildContext context, WidgetRef ref) {
    YOUTUBE_CHANNEL_ID = ref.watch(localUserRepositoryProvider).getLastChurchYTChannel;

    final channelIds = ref.watch(sundayMassServiceProvider).getChurchYouTubeChannelIds;
    final youtubeVideoRepo = ref.watch(youtubeFetchLatestChurchVideoFutureProvider.future);
    const _uiElementCount = 5;

    return FutureBuilder<List<dynamic>>(
      future: youtubeVideoRepo,
      builder: (context, snapshot) {
        if (snapshot.hasError) {
          return Column(
            children: [
              const SundayMassViewHeader(),
              Expanded(
                child: Text(
                  'Cannot access Church at this time. Remember Jesus loves you!',
                  style: Theme.of(context).textTheme.titleLarge,
                ),
              ),
            ],
          );
        }

        if (snapshot.connectionState == ConnectionState.waiting) {
          return Column(
            children: [
              const SundayMassViewHeader(),
              Expanded(
                child: Loading(),
              ),
            ],
          );
        }

        final videoInfo = snapshot.data;

        final videoId = videoInfo[0] as String;
        final channel = videoInfo[1] as YouTubeChannel;

        final _ytController = YoutubePlayerController(
          //initialVideoId: videoId,
          params: const YoutubePlayerParams(
            showFullscreenButton: true,
            strictRelatedVideos: true,
            showVideoAnnotations: false,
          ),
        );

        final _ytPlayer = YoutubePlayer(controller: _ytController);

        return ListView.builder(
          itemCount: channelIds.length + _uiElementCount,
          itemBuilder: (context, index) {
           // if (_ytController.value.isFullScreen) {
           //   SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp, DeviceOrientation.portraitDown]);
           // }

            switch (index) {
              case 0:
                return const SundayMassViewHeader();

              case 1:
                return ClipRRect(borderRadius: BorderRadius.circular(10), child: _ytPlayer);

              case 2:
                return const SizedBox(height: kMediumPadding);

              case 3:
                return Text('Other Church Services', style: Theme.of(context).textTheme.headline5);

              case 4:
                return const SizedBox(height: kSmallPadding);

              default:
                return ChurchYouTubeChannelCard(
                  index: index,
                  uiElementCount: _uiElementCount,
                  videoId: videoId,
                  channelIds: channelIds,
                  channel: channel,
                );
            }
          },
        );
      },
    );
  }
}
