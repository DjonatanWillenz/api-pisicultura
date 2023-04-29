import 'dart:io';

import 'package:app/app/data/dto/home.item.dto.dart';
import 'package:app/app/data/model/dashboard.model.dart';
import 'package:app/app/data/repository/dashboard.repository.dart';
import 'package:app/app/data/repository/installation.repository.dart';
import 'package:app/app/data/repository/notification.repository.dart';
import 'package:app/app/data/repository/task.repository.dart';
import 'package:app/app/data/repository/user.setting.repository.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:get/get.dart';
import 'package:shared_preferences/shared_preferences.dart';

class HomeController extends GetxController {
  final installationRepository = Get.find<InstallationRepository>();
  final settingRepository = Get.find<UserSettingRepository>();
  final taskRepository = Get.find<TaskRepository>();
  final dashboardRepository = Get.find<DashboardRepository>();

  Dashboard dashboard;

  HomeController() {
    _findInstallations();
    _findNotificacoes();
    _findDataDashboard();
  }

  _findDataDashboard() async {
    dashboard = Dashboard.init();
    // if (SettingsSystem.instance.installations.length != 0) {
    //   int id = SettingsSystem.instance.installations[0].id;
    this.dashboard = await dashboardRepository.find(1);
    //if (dashboard != null)
    SettingsSystem.instance.dashboard = dashboard;
    print(SettingsSystem.instance.dashboard);
    //  }
  }

  logout() async {
    SharedPreferences _prefs = await SharedPreferences.getInstance();
    _prefs.setString('username', '');
    _prefs.setString('password', '');
    _prefs.setString('token', '');

    Get.toNamed(Routes.LOGIN);
  }

  RxInt currentIndex = 1.obs;
  RxBool isShowingMainData = true.obs;
  final double width = 7;

  RxList<BarChartGroupData> rawBarGroups = new RxList<BarChartGroupData>();
  RxList<BarChartGroupData> showingBarGroups = new RxList<BarChartGroupData>();

  RxInt touchedGroupIndex = 0.obs;
  NotificationRepository notificacao = Get.find<NotificationRepository>();

  RxInt notifications = 0.obs;
  RxInt touchedIndex = 0.obs;

  _findNotificacoes() async {
    var lista =
        await notificacao.getNotifications(SettingsSystem.instance.user.id);
    if (lista != null) notifications = 1.obs;
  }

  logoutApp() async {
    SharedPreferences _prefs = await SharedPreferences.getInstance();
    _prefs.setString('username', '');
    _prefs.setString('password', '');
    SettingsSystem.instance.logout();
    exit(1);
  }

  _findInstallations() async {
    SettingsSystem.instance.installations = await installationRepository.find();
  }

  findItensDrawer() {
    return [
      HomeItemDto(
        title: "Dashboard",
        svgSrc: "assets/icons/menu_dashbord.svg",
        press: () => Get.toNamed(Routes.HOME),
      ),
      HomeItemDto(
        title: "Instalações",
        svgSrc: "assets/icons/bar-chart.svg",
        press: () => Get.toNamed(Routes.INSTALLATION),
      ),
      HomeItemDto(
        title: "Task",
        svgSrc: "assets/icons/menu_task.svg",
        press: () => Get.toNamed(Routes.TASK),
      ),
      HomeItemDto(
        title: "Store",
        svgSrc: "assets/icons/menu_store.svg",
        press: () => Get.toNamed(Routes.STORE),
      ),
      HomeItemDto(
        title: "Notification",
        svgSrc: "assets/icons/menu_notification.svg",
        press: () => Get.toNamed(Routes.NOTIFICATIONS),
      ),
      HomeItemDto(
        title: "Profile",
        svgSrc: "assets/icons/menu_profile.svg",
        press: () => Get.toNamed(Routes.PROFILE),
      ),
      HomeItemDto(
        title: "Settings",
        svgSrc: "assets/icons/menu_setting.svg",
        press: () => Get.toNamed(Routes.CONFIG),
      ),
      HomeItemDto(
        title: "Logout",
        svgSrc: "assets/icons/logout.svg",
        press: () => logout,
      ),
    ];
  }
}
