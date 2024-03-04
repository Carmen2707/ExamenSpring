package com.example.examenspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping("/post")
    public ResponseEntity<Cliente> nuevo(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.OK);

    }
    @GetMapping("/id/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteRepository.getClienteById(id);
    }

    @GetMapping("/cantidad/{cantidad}")
    public List<Cliente> listaActivos(@PathVariable Long cantidad){
       return clienteRepository.clientesActivos(cantidad);
    }

    @GetMapping("/estadisticas")
    public String getEstadisticas(){
        return "Total de ventas = " +clienteRepository.getTotal()+
                "   Promedio de ventas = "+ clienteRepository.getPromedio()+
                "   Inactivos con total de ventas mayor a 0 ="+clienteRepository.getInactivos();
    }
}
