import 'package:app/app/global/utils/const.color.dart';
import 'package:app/app/global/widgets/widget_icon_button.dart';
import 'package:app/app/modules/home/home.controller.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

// ignore: must_be_immutable
class DwAppBarHome extends StatelessWidget with PreferredSizeWidget {
  HomeController controller;

  DwAppBarHome({
    Key key,
    this.controller,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return PreferredSize(
        preferredSize: Size(1, 1),
        child: AppBar(
          backgroundColor: appThemeData().appBarTheme.backgroundColor,
          actions: <Widget>[
            Positioned(
              child: Obx(
                () => DwIconButton(
                  icon: controller.notifications.value > 0
                      ? Icons.notifications_on_sharp
                      : Icons.notifications_none,
                  corIcon: controller.notifications.value > 0
                      ? Colors.yellow
                      : Colors.white,
                  sizeIcon: controller.notifications > 0 ? 26 : 24,
                  onPressed: () => Get.defaultDialog(
                    title: 'Alerta',
                    backgroundColor: UtilsColor.dialogs,
                    buttonColor: UtilsColor.buttonDialogs,
                    textConfirm: 'Visualizar',
                    textCancel: 'Cancelar',
                    middleText:
                        'Você tem novas mensagens na sua caixa de entrada!',
                    onConfirm: () {
                      Get.back();
                      Get.toNamed(Routes.NOTIFICATIONS);
                    },
                  ),
                ),
              ),
            ),
          ],
        ));
  }

  @override
  Size get preferredSize => Size.fromHeight(kToolbarHeight);
}
