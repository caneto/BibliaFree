import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:url_launcher/url_launcher.dart';

class AboutCard extends ConsumerWidget {
  const AboutCard({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return GestureDetector(
      onTap: () async {
        const link = 'https://31carlton7.github.io/elisha';

        if (await canLaunch(link)) {
          await launch(link);
        } else {
          DoNothingAction();
        }
      },
      child: Card(
        color: CantonMethods.alternateCanvasColorType3(context),
        margin: const EdgeInsets.symmetric(horizontal: 17),
        shape: const RoundedRectangleBorder(
          borderRadius: BorderRadius.vertical(top: Radius.circular(10)),
        ),
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 17, horizontal: 21),
          alignment: Alignment.centerLeft,
          child: Text(
            'About',
            style: Theme.of(context).textTheme.headline6,
          ),
        ),
      ),
    );
  }
}
