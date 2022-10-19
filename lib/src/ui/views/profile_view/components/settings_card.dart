import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/ui/views/settings_view/settings_view.dart';

class SettingsCard extends ConsumerWidget {
  const SettingsCard({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return GestureDetector(
      onTap: () {
        CantonMethods.viewTransition(context, const SettingsView());
      },
      child: Card(
        color: CantonMethods.alternateCanvasColorType3(context),
        margin: const EdgeInsets.symmetric(horizontal: 17),
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10),
        ),
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 17, horizontal: 21),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                'Definições',
                style: Theme.of(context).textTheme.headline6,
              ),
              const Icon(Iconsax.arrow_right_3),
            ],
          ),
        ),
      ),
    );
  }
}
