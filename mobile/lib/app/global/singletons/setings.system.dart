import 'package:app/app/data/model/dashboard.model.dart';
import 'package:app/app/data/model/installation.model.dart';
import 'package:app/app/data/model/user.model.dart';
import 'package:app/app/data/model/user.setting.model.dart';

class SettingsSystem {
  static SettingsSystem _instance;
  User user;
  UserSetting setting;
  List<Installation> installations;
  Dashboard dashboard;

  SettingsSystem._() {
    user = new User();
    setting = new UserSetting();
    dashboard = new Dashboard();
    installations = [];
  }

  static get instance {
    _instance ??= SettingsSystem._();
    return _instance;
  }

  logout() {
    user = null;
    setting = null;
    installations = null;
    dashboard = null;
  }
}
