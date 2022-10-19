import 'package:canton_ui/canton_ui.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/services.dart';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:line_awesome_flutter/line_awesome_flutter.dart';

import 'package:bibliafree/src/config/constants.dart';
import 'package:bibliafree/src/models/chapter.dart';
import 'package:bibliafree/src/providers/reader_settings_repository_provider.dart';
import 'package:bibliafree/src/providers/study_tools_repository_provider.dart';
import 'package:bibliafree/src/ui/components/show_favorite_verse_bottom_sheet.dart';

class BibleReader extends ConsumerWidget {
  const BibleReader({Key? key, required this.chapter}) : super(key: key);

  final Chapter chapter;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    List<Widget> children = [const SizedBox(height: 10)];
    List<InlineSpan> spans = [];
    children.add(
      Container(
        margin: const EdgeInsets.symmetric(horizontal: 32),
        child: Text.rich(
          TextSpan(children: spans),
          style: Theme.of(context).textTheme.headline5!.copyWith(
                fontWeight: FontWeight.w400,
                fontSize: ref.watch(readerSettingsRepositoryProvider.notifier).bodyTextSize * 1.4,
                height: ref.watch(readerSettingsRepositoryProvider.notifier).bodyTextHeight * 1.1,
                fontFamily: ref.watch(readerSettingsRepositoryProvider).typeFace,
              ),
        ),
      ),
    );
    for (int i = 0; i < chapter.verses!.length; i++) {
      var item = chapter.verses![i];
      var _isFavoriteVerse =
          ref.watch(studyToolsRepositoryProvider).favoriteVerses.where((element) => element.id == item.id).isNotEmpty;

      spans.add(
        WidgetSpan(
          child: GestureDetector(
            onTap: () async {
              HapticFeedback.mediumImpact();
              await showFavoriteVerseBottomSheet(context, item);
            },
            child: Padding(
              padding: const EdgeInsets.only(right: 4.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.start,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  if (_isFavoriteVerse)
                    Icon(
                      LineAwesomeIcons.heart_1,
                      size: ref.watch(readerSettingsRepositoryProvider).verseNumberSize * 1.3,
                      color: heartColor(context),
                    ),
                  Text(
                    item.verseId.toString(),
                    style: Theme.of(context).textTheme.bodyText1?.copyWith(
                          color: Theme.of(context).colorScheme.secondaryVariant,
                          fontSize: ref.watch(readerSettingsRepositoryProvider).verseNumberSize * 1.1,
                          // height: ref.watch(readerSettingsRepositoryProvider).verseNumberHeight,
                          fontFamily: ref.watch(readerSettingsRepositoryProvider).typeFace,
                        ),
                  ),
                  if (!_isFavoriteVerse)
                    const Icon(
                      LineAwesomeIcons.heart_1,
                      size: 10,
                      color: CantonColors.transparent,
                    ),
                ],
              ),
            ),
          ),
        ),
      );

      spans.add(
        TextSpan(
          text: item.text,
          recognizer: TapGestureRecognizer()
            ..onTap = () async {
              HapticFeedback.mediumImpact();
              await showFavoriteVerseBottomSheet(context, item);
            },
        ),
      );

      if (!(i == chapter.verses!.length - 1)) {
        spans.add(const TextSpan(text: ' '));
      }
    }

    children.add(const SizedBox(height: 40));

    return SingleChildScrollView(
      child: Column(
        children: [...children],
      ),
    );
  }
}
