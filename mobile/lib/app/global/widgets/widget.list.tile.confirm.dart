import 'package:app/app/global/widgets/widget.text.dart';
import 'package:app/app/global/widgets/widget_icon_button.dart';
import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class DwListTileConfirmm extends StatelessWidget {
  final String title;
  final String leading;
  final String subtitle;
  final Function onDelete;
  final bool visualizado;

  const DwListTileConfirmm({
    Key key,
    this.title,
    this.leading,
    this.subtitle,
    this.visualizado,
    this.onDelete,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    updateList() {
      Navigator.of(context).pop();
      Get.reload();
    }

    selected() {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            clipBehavior: Clip.none,
            title: Text("Detalhes"),
            content:
                Text('Confirmar a exclusão do registro "${title.toString()}"'),
            actions: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                mainAxisSize: MainAxisSize.max,
                children: [
                  TextButton.icon(
                    onPressed: updateList(),
                    icon: Icon(Icons.coronavirus_rounded),
                    label: DwText(lbl: 'Confirmar'),
                  ),
                ],
              ),
            ],
          );
        },
      );
    }

    return Padding(
      padding: EdgeInsets.all(1.5),
      child: Container(
        decoration: BoxDecoration(
          color: appThemeData().cardTheme.color,
          borderRadius: BorderRadius.circular(5),
        ),
        child: ListTile(
          title: Text(
            title,
            style: TextStyle(fontSize: 16),
          ),
          subtitle: Text(
            subtitle,
            style: TextStyle(fontSize: 16),
          ),
          trailing: DwIconButton(
            icon: Icons.contact_support_outlined,
            sizeIcon: 25,
            corIcon: appThemeData().bottomAppBarColor,
            onPressed: () => selected(),
          ),
        ),
      ),
    );
  }
}
