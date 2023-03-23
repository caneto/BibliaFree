import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class SundayMassViewHeader extends ConsumerWidget {
  const SundayMassViewHeader({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return const ViewHeaderTwo(
      title: 'Mass',
      backButton: true,
    );
  }
}
