
import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class BookmarkedChaptersViewHeader extends ConsumerWidget {
  const BookmarkedChaptersViewHeader({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Container(
      padding: const EdgeInsets.only(top: 17, left: 17, right: 17),
      child: Column(
        children: [
          const ViewHeaderTwo(
            title: 'Bookmarks',
            backButton: true,
          ),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 700),
            child: const Divider(),
          ),
        ],
      ),
    );
  }
}
