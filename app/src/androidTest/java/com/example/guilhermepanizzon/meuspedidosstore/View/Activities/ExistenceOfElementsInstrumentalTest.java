package com.example.guilhermepanizzon.meuspedidosstore.View.Activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.guilhermepanizzon.meuspedidosstore.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExistenceOfElementsInstrumentalTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);




    @Test
    public void existenceOfElementsInstrumentalTest() {
        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.card_view),
                        withParent(allOf(withId(R.id.cardList),
                                withParent(allOf(withId(R.id.content_relative_main_layout),
                                        withParent(allOf(withId(R.id.drawer_layout),
                                                withParent(allOf(withId(android.R.id.content),
                                                        withParent(withId(R.id.action_bar_root)))))))))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.name_textview), withText("32\" Full HD Flat Smart TV H5103 Series 3"), isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.price_textview), withText("1466.1"), isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.currency), withText("R$"), isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.photo_imageview_thumbnail), isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.favorite_image_view), isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.content_relative_main_layout),
                        withParent(allOf(withId(R.id.drawer_layout),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.action_bar_root)))))),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.toolbar), isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.btnMyMenu), withContentDescription("Right Side Menu"), isDisplayed()));
        textView4.check(matches(isDisplayed()));

        ViewInteraction drawerLayout = onView(
                allOf(withId(R.id.drawer_layout),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.action_bar_root)))),
                        isDisplayed()));
        drawerLayout.check(matches(isDisplayed()));

        ViewInteraction view = onView(
                allOf(withId(android.R.id.statusBarBackground), isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction view2 = onView(
                allOf(withId(android.R.id.navigationBarBackground), isDisplayed()));
        view2.check(matches(isDisplayed()));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.btnMyMenu), withContentDescription("Right Side Menu"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.search_src_text), withText("Categorias"),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(allOf(withId(R.id.search_edit_frame),
                                        withParent(allOf(withId(R.id.search_bar),
                                                withParent(allOf(withId(R.id.category_search_view),
                                                        withParent(withId(R.id.my)))))))))),
                        isDisplayed()));
        editText.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.search_image_view_icon),
                        withParent(withId(R.id.my)),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textview_all_categories), withText("Todas as categorias    "), isDisplayed()));
        textView5.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.drawer_list_item_text_view), withText("Televisores"), isDisplayed()));
        textView6.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.toolbar), isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.btnMyMenu), withContentDescription("Right Side Menu"), isDisplayed()));
        textView7.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.photo_details_fragment),
                        withParent(withId(R.id.content_relative_main_layout)),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.name_details_textview), withText("32\" Full HD Flat Smart TV H5103 Series 3"),
                        withParent(withId(R.id.content_relative_main_layout)),
                        isDisplayed()));
        textView8.check(matches(isDisplayed()));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.price_textview), withText("1979.1"), isDisplayed()));
        textView9.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.price_details_textview), withText("1466.1"),
                        withParent(withId(R.id.content_relative_main_layout)),
                        isDisplayed()));
        textView10.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.textview_label_descricao_produto), withText("Descrição do produto"),
                        withParent(allOf(withId(R.id.description_relative_layout),
                                withParent(withId(R.id.content_relative_main_layout)))),
                        isDisplayed()));
        textView11.check(matches(isDisplayed()));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.description_details_textview), withText("Com o Modo futebol, é como se você estivesse realmente no jogo. Ele exibe, de forma precisa e viva, a grama verde do campo e todas as outras cores do estádio. Um poderoso efeito de som multi-surround também permite que você ouça toda a empolgação. Você pode até mesmo ampliar áreas selecionadas da tela para uma melhor visualização. Com apenas o toque de um botão, você pode aproveitar ao máximo o seu esporte favorito com todos os seus amigos."),
                        withParent(allOf(withId(R.id.description_relative_layout),
                                withParent(withId(R.id.content_relative_main_layout)))),
                        isDisplayed()));
        textView12.check(matches(isDisplayed()));

        ViewInteraction frameLayout2 = onView(
                allOf(withId(R.id.description_relative_layout),
                        withParent(withId(R.id.content_relative_main_layout)),
                        isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

        pressBack();

    }

}
