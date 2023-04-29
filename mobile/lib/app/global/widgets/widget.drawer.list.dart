import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class DrawerListTile extends StatelessWidget {
  const DrawerListTile({
    Key key,
    @required this.title,
    @required this.svgSrc,
    @required this.press,
  }) : super(key: key);

  final String title, svgSrc;
  final VoidCallback press;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(1.0),
      child: Container(
        decoration: BoxDecoration(
          color: appThemeData().buttonTheme.colorScheme.background,
          borderRadius: BorderRadius.circular(5),
          border: Border.all(width: 1),
        ),
        child: ListTile(
          onTap: press,
          horizontalTitleGap: 0.0,
          hoverColor: Colors.amber,
          leading: SvgPicture.asset(
            svgSrc,
            color: Colors.white,
            height: 24,
          ),
          title: Text(
            title,
            style: TextStyle(color: Colors.white, fontSize: 16),
          ),
        ),
      ),
    );
  }
}
