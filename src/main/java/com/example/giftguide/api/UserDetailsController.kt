package com.example.giftguide.api


import com.example.giftguide.domain.ExtendedUserDetails
import com.example.giftguide.domain.ItemDetails
import com.example.giftguide.domain.UserDetails
import com.example.giftguide.infrastructure.FriendsService
import com.example.giftguide.infrastructure.UserService
import com.example.giftguide.infrastructure.WishlistService
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.FileOutputStream
import java.io.IOException
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import java.io.File
import org.springframework.web.multipart.MultipartResolver
import javax.servlet.MultipartConfigElement


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = ["http://localhost:4200"])
class UserDetailsController(private val userService: UserService,
                            private val wishlistService: WishlistService,
                            private val friendsService: FriendsService) {

    @GetMapping("/{userId}")
    fun getUserDetails(@PathVariable("userId") userId: String): ResponseEntity<ExtendedUserDetails> {
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


    @PostMapping("/{userId}/wishlist/items")
    fun addCustomItemWishlist(@PathVariable("userId") userId: String,
                              @RequestBody itemId: ItemId): ResponseEntity<ItemDetails> {
        val fetchedItem = wishlistService.addItemToWishlist(userId, itemId.id)
        return ResponseEntity(fetchedItem, HttpStatus.OK)
    }

    @GetMapping("/{userId}/friends")
    fun getUsersFriends(@PathVariable("userId") userId: String): ResponseEntity<List<ExtendedUserDetails>> {
        val allFriends = friendsService.getAllFriends(userId)
        val allFriendsDetails = allFriends.map { userService.getUserDetails(it.friendId) }
        return ResponseEntity(allFriendsDetails, HttpStatus.OK)
    }


    @PostMapping(value = ["/{userId}/whislist/items/{itemId}"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @Throws(IOException::class)
    fun uploadFile(@PathVariable("userId") userId: String,
                   @PathVariable("itemId") itemId: String,
                   @RequestParam("file") file: MultipartFile): ResponseEntity<Any> {
        val convertFile = File("/home/kartytko/Pulpit/Szymkat/giftguide/src/main/resources/static/user${userId}/itemId${itemId}/" + file.originalFilename!!)
        convertFile.createNewFile()
        val fout = FileOutputStream(convertFile)
        fout.write(file.bytes)
        fout.close()
        return ResponseEntity(HttpStatus.OK)
    }


}

data class ItemId(val id: String)

