import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class UnexpectedError extends ConsumerWidget {
  const UnexpectedError(this.provider, {Key key}) : super(key: key);

  final AutoDisposeFutureProvider provider;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            'Oops, something unexpected happened :(',
            textAlign: TextAlign.center,
            style: Theme.of(context).textTheme.headlineSmall,
          ),
          const SizedBox(height: 20),
          CantonPrimaryButton(
            buttonText: 'Retry',
            color: Theme.of(context).colorScheme.primary,
            textColor: Theme.of(context).colorScheme.onBackground,
            borderRadius: BorderRadius.circular(27.5),
            containerWidth: MediaQuery.of(context).size.width / 2 - 90,
            containerHeight: 45,
            padding: EdgeInsets.zero,
            onPressed: () => ref.refresh(provider),
          ),
        ],
      ),
    );
  }
}
