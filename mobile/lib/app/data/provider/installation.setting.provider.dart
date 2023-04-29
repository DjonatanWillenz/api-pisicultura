import 'package:app/app/data/model/installation.setting.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class InstallationSettingApiClient extends DwGetConnect {
  find(int idInstallation) async {
    try {
      final response =
          await get(baseUrl + '/app/installation-setting/$idInstallation');
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      print(e);
      return null;
    }
  }

  update(int idInstallation, InstallationSetting setting) async {
    try {
      final response = await put(
          baseUrl + '/app/installation-setting/$idInstallation',
          setting.toJson());
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      print(e);
      return null;
    }
  }
}
