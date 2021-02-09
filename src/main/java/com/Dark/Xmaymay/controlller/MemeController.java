package com.Dark.Xmaymay.controlller;
import com.Dark.Xmaymay.Entity.Meme;
import com.Dark.Xmaymay.Exception.duplicateMemeException;
import com.Dark.Xmaymay.repository.MemeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MemeController {
 @Autowired
 private MemeRepository repository;

 @GetMapping("/memes")
 public List<Meme> retrieveMemes(){
  return repository.findTop100ByOrderByIdDesc();
 }


  @GetMapping("/memes/{id}")
  public ResponseEntity<Meme> retrievebyId(@PathVariable(value = "id") Long id){
   Optional<Meme> Optional=repository.findById(id);
    if(!Optional.isPresent())
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    return new ResponseEntity<Meme>(Optional.get(),HttpStatus.OK);

  }


 @PostMapping("/memes")
 public ResponseEntity<Object> saveMeme(@RequestBody Meme meme){

   Meme isAvail=repository.findByCaptionAndMemeurl(meme.getCaption(), meme.getMemeurl());
     if(isAvail!=null)throw new duplicateMemeException("Meme and caption already exist having author name -> "+ isAvail.getName());
     Meme savedMeme=repository.save(meme);
     JSONObject obj=new JSONObject();
     obj.put("id",savedMeme.getId());
      return  ResponseEntity.status(HttpStatus.CREATED).body(obj.toString());
   }

 @PatchMapping("/memes/{id}")
 public ResponseEntity<?> partialUpdate(@RequestBody Map<String,Object> updates,@PathVariable("id") Long id){
       Meme meme=repository.findById(id).get();
       updates.forEach(
               (update,value)->{
                   switch (update){
                   case "caption": meme.setCaption(value.toString()); break;
                       case "memeurl": meme.setMemeurl(value.toString()); break;
               }
               }
       );
       meme.setId(id);
       Meme isValid=repository.findByCaptionAndMemeurl(meme.getCaption(),meme.getMemeurl());
       if(isValid!=null)throw new duplicateMemeException("You cannot update value as it already exists with author name -> "+ isValid.getName());
       repository.save(meme);
     return ResponseEntity.status(HttpStatus.CREATED).body("updated");
 }

// @DeleteMapping("/memes/{id}")
//    public void deleteById(@PathVariable Long id){
//     repository.deleteById(id);
// }
 }
