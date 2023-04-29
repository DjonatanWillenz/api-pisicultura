import 'package:app/app/data/model/installation.model.dart';
import 'package:app/app/global/utils/const.text.dart';
import 'package:app/app/global/widgets/widget.scaffold.listagem.dart';
import 'package:app/app/global/widgets/widget.text.dart';
import 'package:app/app/global/widgets/widget_list_title.dart';
import 'package:app/app/modules/installation/installation.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class InstallationView extends GetView<InstallationController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffoldListagem(
      title: UtilsTextLabels.INSTALLATION,
      body: FutureBuilder<List<Installation>>(
        future: controller.installations(),
        // ignore: missing_return
        builder: (_, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting)
            return CircularProgressIndicator();
          if (snapshot.connectionState == ConnectionState.done &&
              snapshot.hasData) {
            final lista = snapshot.data;
            return ListView.builder(
              itemCount: lista.length ?? 0,
              itemBuilder: (context, index) {
                if (lista != null)
                  return DwListTile(
                    title: lista[index].name.toString(),
                    leading: (index + 1).toString(),
                    subtitle: lista[index].description.toString(),
                    onDelete: () => controller.onDeleteById(lista[index].id),
                  );
                else
                  return Center(
                    child: DwText(
                      lbl: 'Não encontramos registros',
                    ),
                  );
              },
            );
          }
        },
      ),
    );
  }
}
