import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class FirstNameInput extends ConsumerWidget {
  const FirstNameInput({Key key, this.firstNameController}) : super(key: key);

  final TextEditingController firstNameController;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Container(
      margin: const EdgeInsets.all(7),
      width: MediaQuery.of(context).size.width / 2 - 44,
      child: CantonTextInput(
        hintText: '',
        labelText: 'Primeiro nome',
        isTextFormField: true,
        obscureText: false,
        controller: firstNameController,
        textInputType: TextInputType.name,
      ),
    );
  }
}
