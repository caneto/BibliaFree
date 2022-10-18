import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:url_launcher/url_launcher.dart';

class SupportCard extends ConsumerWidget {
  const SupportCard({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return GestureDetector(
      onTap: () async {
        const link = 'https://31carlton7.github.io/elisha/support';

        if (await canLaunch(link)) {
          await launch(link);
        } else {
          DoNothingAction();
        }
      },
      child: Card(
        color: CantonMethods.alternateCanvasColorType3(context),
        margin: const EdgeInsets.symmetric(horizontal: 17),
        shape: const RoundedRectangleBorder(borderRadius: BorderRadius.zero),
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 17, horizontal: 21),
          alignment: Alignment.centerLeft,
          child: Text(
            'Support',
            style: Theme.of(context).textTheme.headline6,
          ),
        ),
      ),
    );
  }
}
