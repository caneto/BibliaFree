
import 'package:canton_ui/canton_ui.dart';

const String kAppTitle = 'Elisha';

const String kVersionNumber = 'Elisha v1.1.4 (14)';

const natureImages = <String>[
  'assets/images/nature_1.jpg',
  'assets/images/nature_2.jpg',
  'assets/images/nature_3.jpg',
  'assets/images/nature_4.jpg',
  'assets/images/nature_5.jpg',
  'assets/images/nature_6.jpg',
  'assets/images/nature_7.jpg',
  'assets/images/nature_8.jpg',
  'assets/images/nature_9.jpg',
  'assets/images/nature_10.jpg',
];

const churchImages = <String>[
  'assets/images/church_1.jpg',
  'assets/images/church_2.jpg',
  'assets/images/church_3.jpg',
];

Color heartColor(BuildContext context) {
  if (MediaQuery.of(context).platformBrightness == Brightness.dark) {
    return CantonDarkColors.red[400];
  }
  return CantonColors.red[400];
}
