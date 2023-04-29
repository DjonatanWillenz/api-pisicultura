import 'package:app/app/data/model/food.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class FoodApiClient extends DwGetConnect {
  find(int idinstallation) async {
    try {
      final response = await get(baseUrl + '/app/food/$idinstallation');
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      return null;
    }
  }

  update(Food food) async {
    try {
      final response = await put(baseUrl + '/app/food', food.toJson());
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      print(e);
      return null;
    }
  }
}
