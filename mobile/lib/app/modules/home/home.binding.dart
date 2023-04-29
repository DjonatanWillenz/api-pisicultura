import 'package:app/app/data/provider/dashboardd.provider.dart';
import 'package:app/app/data/provider/installation.provider.dart';
import 'package:app/app/data/provider/installation.setting.provider.dart';
import 'package:app/app/data/provider/task.provider.dart';
import 'package:app/app/data/provider/user.setting.provider.dart';
import 'package:app/app/data/repository/dashboard.repository.dart';
import 'package:app/app/data/repository/installation.repository.dart';
import 'package:app/app/data/repository/installation.setting.repository.dart';
import 'package:app/app/data/repository/notification.repository.dart';
import 'package:app/app/data/repository/task.repository.dart';
import 'package:app/app/data/repository/user.setting.repository.dart';
import 'package:app/app/modules/home/home.controller.dart';
import 'package:get/get.dart';

class HomeBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => HomeController());
    Get.lazyPut(() => NotificationRepository());

    Get.lazyPut(() => UserSettingApiClient());
    Get.lazyPut(() => UserSettingRepository());

    Get.lazyPut(() => InstallationSettingRepository());
    Get.lazyPut(() => InstallationSettingApiClient());

    Get.lazyPut(() => InstallationRepository());
    Get.lazyPut(() => InstallationApiClient());

    Get.lazyPut(() => TaskRepository());
    Get.lazyPut(() => TaskApiClient());

    Get.lazyPut(() => DashboardRepository());
    Get.lazyPut(() => DashboardApiClient());
  }
}
