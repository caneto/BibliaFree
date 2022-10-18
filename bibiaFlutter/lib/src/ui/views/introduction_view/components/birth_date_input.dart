import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class BirthDateInput extends ConsumerWidget {
  const BirthDateInput({
    Key? key,
    required this.birthDateText,
    required this.showBirthDatePicker,
  }) : super(key: key);

  final String birthDateText;
  final Future<void> Function() showBirthDatePicker;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return GestureDetector(
      onTap: () async {
        showBirthDatePicker();
      },
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            margin: const EdgeInsets.only(left: 7),
            child: Text(
              'Aniversário (Opcional)',
              style: Theme.of(context).inputDecorationTheme.labelStyle,
            ),
          ),
          Container(
            margin: const EdgeInsets.all(7),
            padding: const EdgeInsets.all(13),
            width: MediaQuery.of(context).size.width,
            decoration: BoxDecoration(
              color: Theme.of(context).inputDecorationTheme.fillColor,
              borderRadius: BorderRadius.circular(kSmallBorderRadius),
            ),
            child: Row(
              children: [
                Text(
                  birthDateText,
                  style: Theme.of(context).inputDecorationTheme.labelStyle,
                )
              ],
            ),
          ),
        ],
      ),
    );
  }
}
