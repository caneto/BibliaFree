import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/youtube_channel.dart';
import 'package:bibliafree/src/providers/youtube_service_provider.dart';

// ignore: non_constant_identifier_names
var YOUTUBE_CHANNEL_ID = '';

final youtubeFetchChannelFutureProvider = FutureProvider.autoDispose<YouTubeChannel>((ref) {
  ref.maintainState = true;

  return ref.watch(youtubeServiceProvider).fetchChannel(YOUTUBE_CHANNEL_ID);
});
