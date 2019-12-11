package com.example.giftguide.api

import com.example.giftguide.domain.ExtendedUserDetails
import com.example.giftguide.domain.ItemDetails
import com.example.giftguide.domain.UserDetails
import com.example.giftguide.infrastructure.UserService
import com.example.giftguide.infrastructure.WishlistService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//POST users/{userId}/events

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = ["http://localhost:4200"])
class EventsController(private val userService: UserService,
                       private val wishlistService: WishlistService) {

    @PostMapping("/{userId}/events")
    fun addNewEvent(@PathVariable("userId") userId: String,
                    @RequestBody eventDetails: EventDetails): ResponseEntity<EventDetails> {
        return ResponseEntity(eventDetails, HttpStatus.OK)
    }

    @GetMapping("/{userId}/events")
    fun fetchAllEvents(@PathVariable("userId") userId: String): ResponseEntity<List<EventDetails>> {
        val eventDetails = EventDetails(title = "Urodzinki Agusi",
                category = "INBA",
                date = "2019-12-20",
                organizer = ExtendedUserDetails(
                        name = "Agnieszka",
                        surname = "Pekala",
                        mail = "agapekala@twojastara.pl",
                        photoUrl = "FOTA.JPG",
                        login = "Dżagusia"
                ),
                description = "To będzie super przyjęcie! Zapraszam!",
                location = "Kraków",
                photoUrl = "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-1/p960x960/28828011_1335117676634038_1424225520892479354_o.jpg?_nc_cat=109&_nc_ohc=cDKBwx3EWNUAQlEiQ0eKvGfDprY8ZC2Wcl8qqXDz2r2VA1B6SrQ0RGONw&_nc_ht=scontent-waw1-1.xx&oh=863c9257e87872fede17d58325fb62ef&oe=5E69F911")
        val eventDetails2 = EventDetails(title = "Oslo sroslo",
                category = "INBA",
                date = "2019-12-05",
                organizer = ExtendedUserDetails(
                        name = "Karolina",
                        surname = "Tytko",
                        mail = "chchchchchch@ujek.pl",
                        photoUrl = "FOTA.JPG",
                        login = "Karzjeb"
                ),
                description = "Kłoda party",
                location = "Krowodrza",
                photoUrl = "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-1/p960x960/28828011_1335117676634038_1424225520892479354_o.jpg?_nc_cat=109&_nc_ohc=cDKBwx3EWNUAQlEiQ0eKvGfDprY8ZC2Wcl8qqXDz2r2VA1B6SrQ0RGONw&_nc_ht=scontent-waw1-1.xx&oh=863c9257e87872fede17d58325fb62ef&oe=5E69F911")
        return ResponseEntity(listOf(eventDetails, eventDetails2), HttpStatus.OK)
    }

}

data class EventDetails(
        val title: String,
        val category: String,
        val date: String,
        val organizer: ExtendedUserDetails,
        val description: String?,
        val location: String?,
        val photoUrl: String?
)