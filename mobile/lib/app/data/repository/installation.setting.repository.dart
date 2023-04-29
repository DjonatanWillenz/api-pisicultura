import 'package:app/app/data/model/installation.setting.model.dart';
import 'package:app/app/data/provider/installation.setting.provider.dart';

class InstallationSettingRepository {
  final InstallationSettingApiClient apiClient = InstallationSettingApiClient();

  find(int idinstallation) async {
    var res = await apiClient.find(idinstallation);
    return res != null
        ? res
            .map<InstallationSetting>((e) => InstallationSetting.fromJson(e))
            .toList()
        : null;
  }

  update(int idInstallation, InstallationSetting entity) async {
    return InstallationSetting.fromJson(
        await apiClient.update(idInstallation, entity));
  }
}
