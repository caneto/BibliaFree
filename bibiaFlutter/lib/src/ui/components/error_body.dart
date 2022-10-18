import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class ErrorBody extends ConsumerWidget {
  final String message;
  final AutoDisposeFutureProvider provider;

  const ErrorBody(this.message, this.provider, {Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Center(
          child: Text(
            message,
            style: Theme.of(context).textTheme.headline6,
          ),
        ),
        const SizedBox(height: 12),
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
    );
  }
}
