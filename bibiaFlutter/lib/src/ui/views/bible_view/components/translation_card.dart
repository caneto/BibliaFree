import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/translation.dart';
import 'package:bibliafree/src/providers/last_translation_book_chapter_provider.dart';

class TranslationCard extends ConsumerWidget {
  const TranslationCard({
    Key? key,
    required this.setState,
    required this.index,
    required this.ref,
    required this.translation,
  }) : super(key: key);

  final void Function(void Function()) setState;
  final WidgetRef ref;
  final int index;
  final Translation translation;

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return GestureDetector(
      onTap: () async {
        await ref.read(localRepositoryProvider.notifier).changeBibleTranslation(
              index - 1,
              translation.abbreviation!.toLowerCase(),
            );

        // ref.refresh(bibleChaptersProvider);
        // ref.refresh(bibleBooksProvider);

        setState(() {});

        Navigator.of(context, rootNavigator: true).pop();
      },
      child: ListTile(
        contentPadding: const EdgeInsets.symmetric(vertical: 3, horizontal: 17),
        title: Text(
          translation.name!,
          style: Theme.of(context).textTheme.headline6?.copyWith(
                fontSize: Responsive.isTablet(context) ? 21 : null,
              ),
        ),
        trailing: Text(
          translation.abbreviation!.toUpperCase(),
          style: Theme.of(context).textTheme.bodyText1?.copyWith(
                color: Theme.of(context).colorScheme.secondaryVariant,
                fontSize: Responsive.isTablet(context) ? 18 : null,
              ),
        ),
      ),
    );
  }
}
