package com.example.peluchitosenterprise


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peluchitosenterprise.ui.Comunicador
import kotlinx.android.synthetic.main.fragment_agregar.view.*

class AgregarFragment : Fragment() {

    var interfaz: Comunicador?=null
    private lateinit var recyclerView: RecyclerView
    var peluchitos:ArrayList<Peluchitos> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_agregar, container, false)

        view.BotonAgg.setOnClickListener {

            var id = view.et_id.text.toString()
            var nombre = view.et_name.text.toString()
            var cantidad = view.et_cantidad.text.toString()
            var precio = view.et_precio.text.toString()

            if(id!="" && nombre!="" && cantidad!="" && precio!="") {
                interfaz?.enviarDatos(id, nombre, cantidad, precio)
                peluchitos.add(
                    Peluchitos(
                        id,
                        nombre,
                        cantidad,
                        precio
                    )
                )

                recyclerView = view.findViewById(R.id.recycler) as RecyclerView
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager =
                    LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)

                val peluchitosAdapter = PeluchitosAdapter(peluchitos!!, view.context)
                recyclerView.adapter = peluchitosAdapter
            }else{
                interfaz?.enviarDatos("", "", "", "")
            }
        }

        return view
    }


}
