import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/chapter.dart';
import 'package:bibliafree/src/ui/views/bookmarked_chapter_view/bookmarked_chapter_view.dart';

class BookmarkedChapterCard extends ConsumerWidget {
  const BookmarkedChapterCard({
    Key key,
    this.chapter,
    this.setState,
    this.showBookmarkedChapterOptionsBottomSheet,
  }) : super(key: key);

  final Chapter chapter;
  final void Function(void Function()) setState;
  final Future<void> Function(Chapter) showBookmarkedChapterOptionsBottomSheet;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    String cardTitle() {
      return chapter.verses[0].book.name + ' ' + chapter.number.toString();
    }

    return GestureDetector(
      onTap: () {
        CantonMethods.viewTransition(context, BookmarkedChapterView(chapter)).then((value) => setState(() {}));
      },
      child: ListTile(
        contentPadding: const EdgeInsets.symmetric(horizontal: 17),
        leading: Text(
          cardTitle(),
          style: Theme.of(context).textTheme.headline6,
        ),
        trailing: GestureDetector(
          onTap: () async {
            await showBookmarkedChapterOptionsBottomSheet(chapter);
          },
          child: Icon(
            Iconsax.more,
            color: Theme.of(context).colorScheme.primary,
          ),
        ),
      ),
    );
  }
}
