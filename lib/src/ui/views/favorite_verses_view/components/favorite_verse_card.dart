import 'package:canton_ui/canton_ui.dart';
import 'package:flutter/services.dart';

import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:line_awesome_flutter/line_awesome_flutter.dart';

import 'package:bibliafree/src/models/verse.dart';
import 'package:bibliafree/src/providers/study_tools_repository_provider.dart';

class FavoriteVerseCard extends ConsumerStatefulWidget {
  const FavoriteVerseCard({Key key, this.verse}) : super(key: key);

  final Verse verse;

  @override
  _FavoriteVerseCardState createState() => _FavoriteVerseCardState();
}

class _FavoriteVerseCardState extends ConsumerState<FavoriteVerseCard> {
  String cardTitle() {
    final str =
        '${widget.verse.book.name} ${widget.verse.chapterId}:${widget.verse.verseId}';

    return str;
  }

  Widget _favoriteButton(BuildContext context, Verse verse) {
    var _isFavorite = verse.favorite;
    Color bgColor() {
      if (MediaQuery.of(context).platformBrightness == Brightness.dark) {
        return CantonDarkColors.gray[800];
      }
      return CantonColors.gray[300];
    }

    Color heartColor() {
      if (MediaQuery.of(context).platformBrightness == Brightness.dark) {
        return CantonDarkColors.red[400];
      }
      return CantonColors.red[400];
    }

    Icon icon() {
      if (verse.favorite) {
        return Icon(LineAwesomeIcons.heart_1, size: 20, color: heartColor());
      }
      return Icon(LineAwesomeIcons.heart, size: 20, color: Theme.of(context).colorScheme.secondaryVariant);
    }

    return GestureDetector(
      onTap: () async {
        HapticFeedback.mediumImpact();

        setState(() {
          _isFavorite = _isFavorite;
        });

        if (_isFavorite) {
          await ref.read(studyToolsRepositoryProvider).addFavoriteVerse(verse);
        } else {
          await ref.read(studyToolsRepositoryProvider).removeFavoriteVerse(verse);
        }
      },
      child: Container(
        height: 35,
        width: 35,
        decoration: BoxDecoration(shape: BoxShape.circle, color: bgColor()),
        child: Center(
          child: icon(),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: const RoundedRectangleBorder(borderRadius: BorderRadius.zero),
      margin: const EdgeInsets.symmetric(vertical: 17),
      color: CantonMethods.alternateCanvasColor(context),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  cardTitle(),
                  style: Theme.of(context).textTheme.headline5,
                ),
                const SizedBox(height: 7),
                Text(
                  widget.verse.text,
                  style: Theme.of(context).textTheme.headline6,
                ),
              ],
            ),
          ),
          _favoriteButton(context, widget.verse),
        ],
      ),
    );
  }
}
