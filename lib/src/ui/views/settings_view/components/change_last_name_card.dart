import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/providers/local_user_repository_provider.dart';

class ChangeLastNameCard extends ConsumerWidget {
  const ChangeLastNameCard({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final _controller = TextEditingController();

    String currentNameStr() {
      return 'Current Last Name: ${ref.watch(localUserRepositoryProvider).getUser.lastName}';
    }

    return CantonExpansionTile(
      title: Text(
        'Change Last Name',
        style: Theme.of(context).textTheme.titleLarge,
      ),
      decoration: BoxDecoration(
        color: CantonMethods.alternateCanvasColorType3(context),
        borderRadius: BorderRadius.zero,
      ),
      backgroundColor: CantonMethods.alternateCanvasColor(context),
      iconColor: Theme.of(context).colorScheme.primary,
      children: [
        Container(
          padding: const EdgeInsets.symmetric(horizontal: 17, vertical: 17),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                currentNameStr(),
                style: Theme.of(context).textTheme.titleLarge,
              ),
              const SizedBox(height: 10),
              CantonTextInput(
                isTextFormField: true,
                obscureText: false,
                hintText: '',
                controller: _controller,
                containerPadding: const EdgeInsets.all(7),
              ),
              const SizedBox(height: 17),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CantonPrimaryButton(
                    buttonText: 'Confirm',
                    color: Theme.of(context).colorScheme.primary,
                    textColor: Theme.of(context).colorScheme.onBackground,
                    containerWidth: 100,
                    containerHeight: 30,
                    padding: EdgeInsets.zero,
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(30)),
                    onPressed: () {
                      final updatedUser =
                          ref.read(localUserRepositoryProvider).getUser.copyWith(lastName: _controller.text);
                      ref.read(localUserRepositoryProvider).updateUser(updatedUser);
                      Navigator.of(context).pop();
                    },
                  ),
                ],
              ),
            ],
          ),
        ),
      ],
    );
  }
}
