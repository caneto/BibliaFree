import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/chapter.dart';

class BookmarkedChapterViewHeader extends ConsumerWidget {
  const BookmarkedChapterViewHeader({required this.chapter, required this.showBottomSheet, Key? key}) : super(key: key);

  final void Function(Chapter) showBottomSheet;
  final Chapter chapter;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    String name() {
      return chapter.verses![0].book.name! + ' ' + chapter.number!;
    }

    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: kDefaultPadding),
      child: ViewHeaderTwo(
        title: name(),
        backButton: true,
        buttonTwo: CantonHeaderButton(
          onPressed: () {
            showBottomSheet(chapter);
          },
          icon: Icon(
            Iconsax.more,
            color: Theme.of(context).primaryColor,
          ),
        ),
      ),
    );
  }
}
