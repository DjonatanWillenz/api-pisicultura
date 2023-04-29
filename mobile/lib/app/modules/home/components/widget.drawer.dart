import 'package:app/app/data/dto/home.item.dto.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:app/app/global/widgets/widget.drawer.list.dart';
import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';

class DwDrawer extends StatelessWidget {
  final List<HomeItemDto> itens;

  DwDrawer({Key key, this.itens}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: SingleChildScrollView(
        child: Container(
          child: Column(
            children: [
              UserAccountsDrawerHeader(
                decoration: BoxDecoration(
                  color: appThemeData().appBarTheme.backgroundColor,
                ),
                currentAccountPicture: Icon(Icons.account_circle, size: 80),
                accountName: Text(
                  SettingsSystem.instance?.user?.name ?? 'Null',
                  style: TextStyle(fontSize: 17),
                ),
                accountEmail: Text(
                  SettingsSystem.instance.user.email ?? 'Null',
                  style: TextStyle(fontSize: 14),
                ),
              ),
              Column(
                children: List.generate(
                  itens.length,
                  (index) => DrawerListTile(
                    title: itens[index].title,
                    svgSrc: itens[index].svgSrc,
                    press: itens[index].press,
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
