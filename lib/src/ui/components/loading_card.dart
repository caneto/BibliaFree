import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:shimmer/shimmer.dart';

class LoadingCard extends ConsumerWidget {
  const LoadingCard({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 17, vertical: 10),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(10),
        color: CantonMethods.alternateCanvasColorType3(context),
      ),
      child: Center(
        child: Shimmer(
          gradient: LinearGradient(colors: [
            Theme.of(context).colorScheme.secondary,
            Theme.of(context).colorScheme.onSecondary,
          ]),
          child: Column(
            children: [
              Container(
                width: double.infinity,
                height: 20,
                color: CantonColors.white,
              ),
              const SizedBox(height: 10),
              Container(
                width: double.infinity,
                height: 20,
                color: CantonColors.white,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
