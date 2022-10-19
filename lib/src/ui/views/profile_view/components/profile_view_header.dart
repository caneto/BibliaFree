import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/providers/local_user_repository_provider.dart';

class ProfileViewHeader extends ConsumerWidget {
  const ProfileViewHeader({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    String? dbName = ref.watch(localUserRepositoryProvider).getUser.firstName;

    String name(String source) {
      if (source.length > 18) {
        return source.substring(0, 15) + '...';
      }
      return 'Oi, ' + source;
    }

    return Container(
      padding: const EdgeInsets.only(top: kSmallPadding, left: kDefaultPadding * 2, right: kDefaultPadding),
      child: Text(name(dbName), style: Theme.of(context).textTheme.headline2?.copyWith(fontWeight: FontWeight.w700)),
    );
  }
}
