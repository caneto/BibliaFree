import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class FavoriteVersesViewHeader extends ConsumerWidget {
  const FavoriteVersesViewHeader({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Column(
      children: [
        Container(
          padding: const EdgeInsets.only(top: 10),
          child: const ViewHeaderTwo(
            title: 'Favorite Verses',
            backButton: true,
          ),
        ),
        ConstrainedBox(
          constraints: const BoxConstraints(maxWidth: 700),
          child: const Divider(),
        ),
      ],
    );
  }
}
