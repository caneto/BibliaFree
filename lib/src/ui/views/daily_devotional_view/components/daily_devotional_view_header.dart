import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class DailyDevotionalViewHeader extends ConsumerWidget {
  const DailyDevotionalViewHeader({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Row(
      children: const [CantonBackButton(isClear: true)],
    );
  }
}
