import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/providers/local_user_repository_provider.dart';

class HomeViewHeader extends ConsumerWidget {
  const HomeViewHeader({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    String greeting() {
      var hour = DateTime.now().hour;
      if (hour < 12) {
        return 'Manhã';
      }
      if (hour > 12) {
        return 'Tarde';
      }
      if (hour > 18) {
        return 'Noite';
      }
      return 'Tarde';
    }

    String name(String source) {
      if (source.length > 18) {
        return '${source.substring(0, 15)}...';
      }
      return source;
    }

    String dbName = ref.watch(localUserRepositoryProvider).getUser.firstName;

    return GestureDetector(
      child: Container(
        padding: const EdgeInsets.symmetric(vertical: 25, horizontal: 30),
        child: Text(
          'Boa ' + greeting() + ', ' + (dbName != '' ? name(dbName) : ''),
          style: Theme.of(context).textTheme.headline2?.copyWith(letterSpacing: 0.1),
        ),
      ),
    );
  }
}
