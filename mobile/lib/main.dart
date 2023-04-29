import 'package:app/app/modules/initial/initial.binding.dart';
import 'package:app/app/routes/app_pages.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);
  runApp(
    GetMaterialApp(
      title: "Gerenciador",
      debugShowCheckedModeBanner: false,
      theme: appThemeData(),
      initialRoute: Routes.INITIAL,
      getPages: AppPages.pages,
      initialBinding: InitialBinding(),
    ),
  );
}
