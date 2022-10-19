import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class SomethingWentWrong extends ConsumerWidget {
  const SomethingWentWrong({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            'Something went wrong',
            style: Theme.of(context).textTheme.headline5!.copyWith(
                  color: Theme.of(context).colorScheme.secondaryVariant,
                ),
          ),
          const SizedBox(height: 20),
          CantonPrimaryButton(
            buttonText: 'Sign out',
            textColor: CantonColors.white,
            color: Theme.of(context).primaryColor,
            containerWidth: MediaQuery.of(context).size.width / 2 - 34,
            onPressed: () {
              // ref.read(authenticationRepositoryProvider).signOut();
            },
          ),
        ],
      ),
    );
  }
}
