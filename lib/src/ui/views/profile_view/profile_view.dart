import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/ui/components/streaks_card.dart';
import 'package:bibliafree/src/ui/views/profile_view/components/bookmarks_card.dart';
import 'package:bibliafree/src/ui/views/profile_view/components/favorite_verses_card.dart';
import 'package:bibliafree/src/ui/views/profile_view/components/profile_view_header.dart';
import 'package:bibliafree/src/ui/views/profile_view/components/settings_card.dart';

class ProfileView extends ConsumerWidget {
  const ProfileView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return _content(context);
  }

  Widget _content(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          _body(context),
        ],
      ),
    );
  }

  Widget _body(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const ProfileViewHeader(),
        const SizedBox(height: 17),
        ConstrainedBox(
          constraints: const BoxConstraints(maxWidth: 500),
          child: const StreaksCard(marginalPadding: true),
        ),
        const SizedBox(height: 17),
        ConstrainedBox(
          constraints: const BoxConstraints(maxWidth: 500),
          child: const BookmarksCard(),
        ),
        ConstrainedBox(
          constraints: const BoxConstraints(maxWidth: 500),
          child: const FavoriteVersesCard(),
        ),
        const SizedBox(height: 17),
        ConstrainedBox(
          constraints: const BoxConstraints(maxWidth: 500),
          child: const SettingsCard(),
        ),
        const SizedBox(height: kDefaultPadding)
      ],
    );
  }
}
