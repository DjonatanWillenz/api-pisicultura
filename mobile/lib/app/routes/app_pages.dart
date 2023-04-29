import 'package:app/app/modules/initial/initial.binding.dart';
import 'package:app/app/modules/initial/initial.view.dart';
import 'package:app/app/modules/home/home.binding.dart';
import 'package:app/app/modules/home/home.view.dart';
import 'package:app/app/modules/installation/installation.binding.dart';
import 'package:app/app/modules/installation/installation.view.dart';
import 'package:app/app/modules/notifications/list.notification.view.dart';
import 'package:app/app/modules/notifications/notification.binding.dart';
import 'package:app/app/modules/settings/setting.system.binding.dart';
import 'package:app/app/modules/settings/setting.system.view.dart';
import 'package:app/app/modules/store/list.store.view.dart';
import 'package:app/app/modules/store/store.binding.dart';
import 'package:app/app/modules/task/list.task.view.dart';
import 'package:app/app/modules/task/task.binding.dart';
import 'package:app/app/modules/user/auth/auth.binding.dart';
import 'package:app/app/modules/user/auth/auth.view.dart';
import 'package:app/app/modules/user/register/user.view.dart';
import 'package:app/app/modules/user/register/user.binding.dart';
import 'package:app/app/modules/user/setings/setings.user.binding.dart';
import 'package:app/app/modules/user/setings/setings.user.view.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:get/get.dart';

abstract class AppPages {
  static final pages = [
    GetPage(
      name: Routes.INITIAL,
      page: () => InitialView(),
      binding: InitialBinding(),
    ),
    GetPage(
      name: Routes.INSTALLATION,
      page: () => InstallationView(),
      binding: InstallationBinding(),
    ),
    GetPage(
      name: Routes.LOGIN,
      page: () => AuthView(),
      binding: AuthBinding(),
    ),
    GetPage(
      name: Routes.HOME,
      page: () => HomeView(),
      binding: HomeBinding(),
    ),
    GetPage(
      name: Routes.CONFIG,
      page: () => SettingsSystemView(),
      binding: SettingsSystemBinding(),
    ),
    GetPage(
      name: Routes.POST_USER,
      page: () => RegisterUserView(),
      binding: UserBinding(),
    ),
    GetPage(
      name: Routes.NOTIFICATIONS,
      page: () => NotificationViewList(),
      binding: NotificationBinding(),
    ),
    GetPage(
      name: Routes.PROFILE,
      page: () => SetingsUserSystemView(),
      binding: SetingsUserSystemBinding(),
    ),
    GetPage(
      name: Routes.CONFIG,
      page: () => SettingsSystemView(),
      binding: SettingsSystemBinding(),
    ),
    GetPage(
      name: Routes.TASK,
      page: () => TaskViewList(),
      binding: TaskBinding(),
    ),
    GetPage(
      name: Routes.STORE,
      page: () => StoreViewList(),
      binding: StoreBinding(),
    ),
  ];
}
