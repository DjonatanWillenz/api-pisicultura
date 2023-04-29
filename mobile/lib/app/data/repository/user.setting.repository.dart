import 'package:app/app/data/model/user.setting.model.dart';
import 'package:app/app/data/provider/user.setting.provider.dart';
import 'package:app/app/global/singletons/setings.system.dart';

class UserSettingRepository {
  final UserSettingApiClient apiClient = UserSettingApiClient();

  Future<UserSetting> update(UserSetting setting) async {
    setting.iduser = SettingsSystem.instance.user.id;
    var result = await apiClient.update(setting);
    return result != null ? UserSetting.fromMap(result) : null;
  }

  find() async {
    var result = await apiClient.find(SettingsSystem.instance.user.id);
    if (result != null) {
      UserSetting setting = UserSetting.fromMap(result);
      SettingsSystem.instance.setting = setting;
      return setting;
    }
    return null;
  }
}
