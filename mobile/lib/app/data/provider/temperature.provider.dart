import 'package:app/app/data/model/temperature.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class TemperatureApiClient extends DwGetConnect {
  find(int idinstallation) async {
    try {
      final response = await get(baseUrl + '/app/temperature/$idinstallation');
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      return null;
    }
  }

  update(Temperature temperature) async {
    try {
      final response =
          await put(baseUrl + '/app/temperature', temperature.toJson());
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      print(e);
      return null;
    }
  }
}
