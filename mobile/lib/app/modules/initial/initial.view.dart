import 'package:app/app/global/widgets/widget.text.dart';
import 'package:app/app/global/widgets/widget.text.click.dart';
import 'package:app/app/modules/initial/initial.controller.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:splashscreen/splashscreen.dart';

class InitialView extends GetView<InitialController> {
  InitialView() {
    controller.auth();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: appThemeData().backgroundColor,
      body: Stack(
        children: <Widget>[
          SplashScreen(
            seconds: 10,
            navigateAfterSeconds: Routes.LOGIN,
            loaderColor: appThemeData().backgroundColor,
            loadingText: Text("Carregando..."),
          ),
          LayoutBuilder(builder: (_, constraints) {
            return Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                SizedBox(height: constraints.maxHeight * .1),
                Image.asset(
                  "assets/logo.png",
                  fit: BoxFit.cover,
                  height: constraints.maxHeight * .25,
                  width: constraints.maxWidth * .25,
                ),
                DwText(lbl: "  Bem vindo", fontSize: 30, cor: Colors.blue),
                SizedBox(height: constraints.maxHeight * .35),
                DwTextClick(
                  lbl: 'www.dwsoftsolucoes.com.br',
                  fontSize: 22,
                  cor: Colors.blue,
                  fun: () => {},
                ),
              ],
            );
          })
        ],
      ),
    );
  }
}
