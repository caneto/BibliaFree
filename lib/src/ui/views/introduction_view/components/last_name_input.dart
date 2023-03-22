import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class LastNameInput extends ConsumerWidget {
  const LastNameInput({Key key, this.lastNameController}) : super(key: key);

  final TextEditingController lastNameController;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Container(
      margin: const EdgeInsets.all(7),
      width: MediaQuery.of(context).size.width / 2 - 44,
      child: CantonTextInput(
        hintText: '',
        labelText: 'Sobrenome',
        isTextFormField: true,
        obscureText: false,
        controller: lastNameController,
        textInputType: TextInputType.name,
      ),
    );
  }
}
