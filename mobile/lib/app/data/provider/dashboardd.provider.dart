import 'package:app/app/data/base.url.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';
import 'package:app/app/global/singletons/setings.system.dart';

class DashboardApiClient extends DwGetConnect {
  dynamic find(int idinstallation) async {
    try {
      int iduser = SettingsSystem.instance.user.id;
      final response =
          await get(baseUrl + '/app/dashboard/$iduser/$idinstallation');
      return response.statusCode == 200 ? response.body as List : null;
    } catch (e) {
      return null;
    }
  }
}
