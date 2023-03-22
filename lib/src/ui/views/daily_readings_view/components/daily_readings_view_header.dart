import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class DailyReadingsViewHeader extends ConsumerWidget {
  const DailyReadingsViewHeader({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 10),
      child: const ViewHeaderTwo(
        backButton: true,
        title: 'Daily Readings',
      ),
    );
  }
}
