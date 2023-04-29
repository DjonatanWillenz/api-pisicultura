import 'package:app/app/global/widgets/widget.scaffold.listagem.dart';
import 'package:app/app/modules/task/task.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class StoreViewList extends GetView<TaskController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffoldListagem(
        // title: UtilsTextLabels.LEMBRETE,
        // body: FutureBuilder<List<Notifications>>(
        //   future: controller.findByIdUser(),
        //   // ignore: missing_return
        //   builder: (_, snapshot) {
        //     if (snapshot.connectionState == ConnectionState.waiting)
        //       return CircularProgressIndicator();
        //     if (snapshot.connectionState == ConnectionState.done &&
        //         snapshot.hasData) {
        //       final lista = snapshot.data;
        //       return ListView.builder(
        //         itemCount: lista.length ?? 0,
        //         itemBuilder: (context, index) {
        //           if (lista != null)
        //             return DwListTile(
        //               title: lista[index].title.toString(),
        //               leading: (index + 1).toString(),
        //               subtitle: lista[index].description.toString(),
        //               onDelete: () => controller.deleteById(lista[index].id),
        //             );
        //           else
        //             return Center(
        //               child: DwText(
        //                 lbl: 'Não encontramos registros',
        //               ),
        //             );
        //         },
        //       );
        //     }
        //   },
        // ),
        );
  }
}
