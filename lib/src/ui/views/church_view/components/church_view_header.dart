import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class ChurchViewHeader extends ConsumerWidget {
  const ChurchViewHeader({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: 25, horizontal: 17),
      child: Row(children: [Text('Church', style: Theme.of(context).textTheme.headline2)]),
    );
  }
}
