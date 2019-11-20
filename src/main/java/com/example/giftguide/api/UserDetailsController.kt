package com.example.giftguide.api


import com.example.giftguide.domain.ItemDetails
import com.example.giftguide.domain.UserDetails
import com.example.giftguide.infrastructure.UserService
import com.example.giftguide.infrastructure.WishlistService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserDetailsController(private val userService: UserService,
                            private val wishlistService: WishlistService) {

    @GetMapping("/{userId}")
    fun getUserDetails(@PathVariable("userId") userId: String): ResponseEntity<UserDetails> {
        val userDetails = userService.getUserDetails(userId)
        return ResponseEntity(userDetails, HttpStatus.OK)
    }

    @GetMapping("/{userId}/wishlist")
    fun getUserWishlist(@PathVariable("userId") userId: String): ResponseEntity<List<ItemDetails>> {
        val items = wishlistService.getUserWishlist(userId)
        return ResponseEntity(items, HttpStatus.OK)
    }

    @PostMapping("/{userId}/whislist/items")
    fun addCustomItemToWishlist(@PathVariable("userId") userId: String,
                                @RequestBody customItem: ItemDetails): ResponseEntity<ItemDetails> {
        val insertedItem = wishlistService.addCustomItemToWishlist(userId, customItem)
        return ResponseEntity(insertedItem, HttpStatus.OK)
    }

//    @PatchMapping("/{userId}/whislist/items/{itemId}")
//    fun addPhotoToCustomItem(@PathVariable("userId") userId: String,
//                             @PathVariable("itemId") itemId: String,
//                             @RequestBody customItem: ItemDetails): ResponseEntity<ItemDetails> {
//    }

    @PostMapping("/{userId}/wishlist/items")
    fun addCustomItemWishlist(@PathVariable("userId") userId: String,
                              @RequestBody itemId: ItemId): ResponseEntity<ItemDetails> {
        val fetchedItem = wishlistService.addItemToWishlist(userId, itemId.id)
        return ResponseEntity(fetchedItem, HttpStatus.OK)
    }
}

data class ItemId(val id: String)

