import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class SettingsViewHeader extends ConsumerWidget {
  const SettingsViewHeader({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return const ViewHeaderTwo(
      title: 'Settings',
      backButton: true,
    );
  }
}
